import frida
import sys
import os

packageName = "me.shingle.fridatest"


def messagesCallback(message, data):
    if message['type'] == 'send':
        print(message['payload'])
    elif message['type'] == 'error':
        print(message['stack'])


hookCode = None
with open(os.path.dirname(os.path.realpath(__file__)) + '/hookTest.js') as f:
    hookCode = f.read()

process = frida.get_remote_device().attach(packageName)
print(process)
process.enable_debugger()
script = process.create_script(hookCode)
script.on('message', messagesCallback)
script.load()
sys.stdin.read()
