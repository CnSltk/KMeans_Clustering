import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns

df = pd.read_csv("output_clusters.csv", header=None)
features = df.columns[:-1]
df.columns = ['f1', 'f2', 'f3', 'f4', 'cluster']

sns.pairplot(df, hue="cluster", palette="Set2")
plt.suptitle("K-Means Clustering on Iris", y=1.02)
plt.show()
