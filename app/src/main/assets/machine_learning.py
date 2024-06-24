import numpy as np
import sys
import pandas as pd
from sklearn.preprocessing import StandardScaler

from sklearn.model_selection import train_test_split

from sklearn import tree

from sklearn.tree import DecisionTreeClassifier

from sklearn.metrics import accuracy_score

from sklearn.ensemble import RandomForestClassifier
from sklearn.metrics import accuracy_score, classification_report


df = pd.read_csv('C:\\Users\\user\\Desktop\\depression_anxiety_data.csv')
# print(df.head())
# len(df)
# print(df.dtypes)
# print(df.columns)



columns = ['who_bmi','depression_severity','anxiety_severity','epworth_score','sleepiness']

df = df.drop(columns, axis=1)



df = df.dropna(subset=['bmi'])
df = df.dropna(subset=['depressiveness'])
df = df.dropna(subset=['anxiety_diagnosis'])
df = df.dropna(subset=['depression_treatment'])
df = df.dropna(subset=['anxiousness'])
df = df.dropna(subset=['anxiety_treatment'])
df = df.dropna(subset=['depression_diagnosis'])
df = df[df['bmi'] != 0]

#print(df)



X=df[['school_year','age','gender','bmi','phq_score','suicidal','depression_diagnosis','depression_treatment',
       'anxiousness', 'anxiety_diagnosis', 'anxiety_treatment']]

df["depressiveness"] = df["depressiveness"].astype(int)
y=df['depressiveness']



ohe = pd.get_dummies(data=df, columns=['gender', 'suicidal', 'depression_diagnosis', 'depression_treatment', 'anxiousness', 'anxiety_diagnosis', 'anxiety_treatment'])
ohe=ohe.drop(columns=['depressiveness'])
ohe=ohe.drop(columns=['id'])
# print(ohe)
X=ohe
df["depressiveness"] = df["depressiveness"].astype(int)
y=df['depressiveness']


X_train, X_test, y_train, y_test = train_test_split(X.values, y.values, test_size=0.25, random_state=4)

from sklearn import svm
scaler = StandardScaler()
X_train = scaler.fit_transform(X_train)
#Create a svm Classifier
clf_svm = svm.SVC(kernel='linear') # Linear Kernel

clf_svm = clf_svm.fit(X_train, y_train)
predictions=clf_svm.predict(X_test)
#print(X_train)
# print(list(predictions))
# print(list(y_test))
# print(accuracy_score(predictions,y_test))

# print(ohe.keys)

data=[[3,21,22,15,15,1,0,1,1,0,0,1,0,1,1,0,1,0]]
#new_predictions = clf_svm.predict(new_data)
#print(new_predictions)



def check(data):
    new_prediction=clf_svm.predict(data)
def predict(data):
    data = scaler.transform(data)  # Standardizeaza datele de intrare
    result = clf_svm.predict(data)
    return result.tolist()


# Apelează funcția predict cu datele primite de la Java
if __name__ == "__main__":
    data = np.array([list(map(float, sys.argv[2:]))])  # Ignoră primele două argumente care sunt numele scriptului și numele funcției
    result = predict(data)
    print(result)  # Returnează rezultatul către Java