import discord
from discord.ext import commands,tasks
import os
from dotenv import load_dotenv
import yt_dlp as youtube_dl

TOKEN = 'MTE5NDg2MDk0MDQ3NTI0MDUwOA.GhUugm.wnhJh23WXZyyG_YwZdokLX-Dk_JnR2hVAky90o'

#

youtube_dl.utils.bug_reports_message = lambda: ''

ytdl_format_options = {
    'format': 'bestaudio/best',
    'restrictfilenames': True,
    'noplaylist': True,
    'nocheckcertificate': True,
    'ignoreerrors': False,
    'logtostderr': False,
    'quiet': True,
    'no_warnings': True,
    'default_search': 'auto',
    'source_address': '0.0.0.0' # bind to ipv4 since ipv6 addresses cause issues sometimes
}

ffmpeg_options = {
    'options': '-vn'
}

ytdl = youtube_dl.YoutubeDL(ytdl_format_options)

class YTDLSource(discord.PCMVolumeTransformer):
    def __init__(self, source, *, data, volume=0.5):
        super().__init__(source, volume)
        self.data = data
        self.title = data.get('title')
        self.url = ""

    @classmethod
    async def from_url(cls, url, *, loop=None, stream=False):
        loop = loop or asyncio.get_event_loop()
        data = await loop.run_in_executor(None, lambda: ytdl.extract_info(url, download=not stream))
        if 'entries' in data:
            # take first item from a playlist
            data = data['entries'][0]
        filename = data['title'] if stream else ytdl.prepare_filename(data)
        return filename

#

intents = discord.Intents.default()
client = discord.Client(intents=intents)
intents.members = True
intents.message_content = True
bot = commands.Bot(command_prefix='!!', intents=intents)

@bot.event
async def on_ready():
    print( "Please welcome the bot to the server, and kindly treat it with respect." )

@bot.event
async def on_message(message):
    if message.content.startswith("!!hello"):
        await message.channel.send("Hello.")
    else:
        await bot.process_commands(message)

@bot.command(name='join', help='Allow for the bot to join the designated voice channel.')
async def join(ctx):
    if not ctx.message.author.voice:
        await ctx.send("{} never joined a voice channel to allow for the bot entry. Please join a channel first.".format(ctx.message.author.name))
    else:
        channel = ctx.message.author.voice.channel
        await channel.connect()
    voice_client = ctx.message.guild.voice_client
    if voice_client.is_connected():
        await ctx.send( "The bot already joined a voice channel within the server." )

@bot.command(name='leave', help='Allow for the bot to leave the recently joined channel.')
async def leave(ctx):
    voice_client = ctx.message.guild.voice_client
    if voice_client.is_connected():
        await voice_client.disconnect()
    else:
        await ctx.send( "The bot never joined a voice channel." )
    if not ctx.message.author.voice:
        await ctx.send( "The users must first join a voice channel to ask the bot to depart from one." )

@bot.command(name='hello', help='The bot shall respond with a kind gesture.')
async def hello(ctx):
    await ctx.send( "Hello." )

@bot.command(name='information', help='The bot shall respond with information regarding its feature-set.')
async def information(ctx):
    await ctx.send( "This bot runs on Python, focusing on the playback of music." )

@bot.command(name='play', help='Users may play a song through YouTube, through a linking of a URL directly after the command, with a space between the command and the URL.')
async def play(ctx,url):
    try:
        server = ctx.message.guild
        voice_channel = server.voice_client
        async with ctx.typing():
            filename = await YTDLSource.from_url(url, loop=bot.loop)
            voice_channel.play(discord.FFmpegPCMAudio(executable="ffmpeg.exe", source=filename))
        await ctx.send('**Now playing:** {}'.format(filename))
    except:
        await ctx.send( "The user never allowed the bot to enter a voice channel. The bot must connect to a voice channel to play music." )

@bot.command(name='pause', help='The bot shall pause the queue, awaiting an eventual play command.')
async def pause(ctx):
    voice_client = ctx.message.guild.voice_client
    if voice_client.is_playing():
        await voice_client.pause()
    else:
        await ctx.send( "The bot exists as currently empty in the queue." )

@bot.command(name='resume', help='The bot eventually resumes the music, after initially pausing it earlier.')
async def resume(ctx):
    voice_client = ctx.message.guild.voice_client
    if voice_client.is_paused():
        await voice_client.resume()
    else:
        await ctx.send( "The queue for the bot never experienced a pause in play." )

@bot.command(name='stop', help='Users may immediately stop any playback of the queue, emptying it.')
async def stop(ctx):
    voice_client = ctx.message.guild.voice_client
    if voice_client.is_playing():
        await voice_client.stop()
    else:
        await ctx.send( "The queue already existed as inactive prior to the command." )

if __name__ == "__main__":
    bot.run( 'MTE5NDg2MDk0MDQ3NTI0MDUwOA.GhUugm.wnhJh23WXZyyG_YwZdokLX-Dk_JnR2hVAky90o' )