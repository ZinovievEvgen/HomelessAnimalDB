# -*- coding: utf-8 -*-
"""Untitled11.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1G2WmpHso1tgbBlmiyc0NVspqEXZEFKB3
"""
from sklearn.model_selection import train_test_split
import pandas as pd
import numpy as np
import re

import matplotlib.pyplot as plt

from nltk.corpus import stopwords
from sklearn.manifold import TSNE
from matplotlib.colors import ListedColormap
from sklearn.model_selection import train_test_split
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn import decomposition
from sklearn.preprocessing import StandardScaler
from sklearn.datasets import make_moons, make_circles, make_classification
from sklearn.neural_network import MLPClassifier
from sklearn.neighbors import KNeighborsClassifier
from sklearn.svm import SVC
from sklearn.gaussian_process import GaussianProcessClassifier
from sklearn.gaussian_process.kernels import RBF
from sklearn.tree import DecisionTreeClassifier
from sklearn.ensemble import RandomForestClassifier, AdaBoostClassifier
from sklearn.naive_bayes import GaussianNB
from sklearn.discriminant_analysis import QuadraticDiscriminantAnalysis
from sklearn.multiclass import OneVsRestClassifier

h = 5.0  # step size in the mesh

names = ["Nearest Neighbors", 
         "Decision Tree", 
         "Random Forest", 
         "Neural Net", 
         "AdaBoost",
         "Naive Bayes"
        ]

classifiers = [
    KNeighborsClassifier(20),
    DecisionTreeClassifier(max_depth=20),
    RandomForestClassifier(max_depth=20, n_estimators=15, criterion='entropy'),
    MLPClassifier(alpha=0.00001, max_iter=1000, hidden_layer_sizes=750, solver='adam'),
    AdaBoostClassifier(DecisionTreeClassifier(max_depth=20), n_estimators=15)
]


df = pd.read_csv('dataset.csv', index_col='Unnamed: 0')
'''df.sort_values(by='Unnamed: 0.1', inplace=True)
df.drop(columns='Unnamed: 0.1', inplace=True)
df.to_csv('dataset.csv')'''





