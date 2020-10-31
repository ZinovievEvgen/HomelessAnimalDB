from sklearn.preprocessing import LabelEncoder
import pandas as pd
import numpy as np


df = pd.read_excel('files/Data_set.xlsx', header=1)
print(df.columns)

df = df[['вид ', 'размер','окрас','шерсть','уши','хвост']]
print(df)

df['вид '] = df['вид '].apply(lambda x: x.lower().strip())
df['шерсть'] = df['шерсть'].apply(lambda x: x.lower().strip())
print(df)

mapper={}
m = {}

for x in df.columns:
     mapper[x]=LabelEncoder()


for x in df.columns:
     df[x]=mapper[x].fit_transform(df.__getattr__(x))
     mapping = dict(zip(mapper[x].classes_, range(0, len(mapper[x].classes_))))
     print(mapping)
     m[x] = len(df[x].unique())

print(m)
print(df)







