import numpy as np
from flask import Flask, abort, jsonify, request, json
import pandas as pd 
import matplotlib.pyplot as plt
import pickle

with open("/home/syrine/PFA2/scriptPython/model_k1.pkl", 'rb') as file:  
    model = pickle.load(file)


app= Flask(__name__)

@app.route('/api', methods=['POST'])
def make_predict():
	data = request.get_json(force=True)
	d1 = data['ai']
	d2 = data['sc']
	d = [[d1,d2]]
	print (d)
	predict_request = d
	#predict_request = np.array(predict_request)
	rez =model.predict(predict_request)
	output = rez[0]
	print (output)
	return jsonify(results=int(output))

if __name__ == '__main__':
	app.run(port = 9000, debug = True)
