from flask import Flask
from flask_restful import Api, Resource, reqparse
import smtplib
import random
import easyufw.easyufw as ufw

app = Flask(__name__)
api = Api(app)

users = [
    	{
        	"name": "Harish",
        	"age": "42",
        	"occupation": "pari.harish@gmail.com",
        	"count": 0
    	},
	{
        	"name": "Hemant",
        	"age": "42",
        	"occupation": "hemant.gaur11@gmail.com",
        	"count": 0
    	}

]

ipList = {}


def sendmail(email):
    s = smtplib.SMTP('smtp.gmail.com', 587)

    # start TLS for security
    s.starttls()

    # Authentication
    s.login("", "")

    # message to be sent
    message = "Message_you_need_to_send" + str(random.randint(1, 100000))

    # sending the mail
    s.sendmail("remoteaccessdagdi@gmail.com", email, message)

    # terminating the session
    s.quit()
    return message


class User(Resource):
    def get(self, name):
	remoteaddress = reqparse.request.headers.environ["REMOTE_ADDR"]

        if remoteaddress in ipList:
            ipList[remoteaddress] = ipList[remoteaddress] + 1
        else:
            ipList[remoteaddress] = 1

	if ipList[remoteaddress] > 5:
            return "", 403	

	print "Client Ip address is " + reqparse.request.headers.environ["REMOTE_ADDR"]

        for user in users:
            if name == user["name"] and user["count"] < 5:
                message = sendmail(user["occupation"])
                user["age"] = message
                return "welcome " + user["name"], 200
        return "User not found", 404


class Access(Resource):
    def get(self, name, message):
	remoteaddress = reqparse.request.headers.environ["REMOTE_ADDR"]
        if ipList[remoteaddress] > 5:
            return "", 403

        if remoteaddress in ipList:
            ipList[remoteaddress] = ipList[remoteaddress] + 1
        else:
            ipList[remoteaddress] = 1

        for user in users:
            if name == user["name"] and message == user["age"] and user["count"] < 5:
		ip = reqparse.request.headers.environ["REMOTE_ADDR"]
                ufw.run('allow from ' + ip + ' to any port 22')
		print "Client Ip address is " + ip
		user["count"] = 0
		return "Successfully completed action for you, you have unlimited power now", 200
        return "User not found", 404


api.add_resource(Access, "/access/<string:name>/<string:message>")


api.add_resource(User, "/user/<string:name>")

app.run(host='0.0.0.0',debug=True)
