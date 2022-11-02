import math
import random
import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt
import seaborn as sns
sns.set_style('darkgrid')

r = 2
N = 5000
d = {"Trials": [], "Pi": []}

for Trial in range(1, N):
    circle_p = 0
    for i in range(Trial):
        x = random.uniform(-r, r)
        y = random.uniform(-r, r)
        if math.sqrt(x**2 + y**2) <= r:
            circle_p += 1
    d["Trials"].append(Trial)
    d["Pi"].append((circle_p / Trial) * 4)
    
df = pd.DataFrame(data=d)
fig, axs = plt.subplots(2, 1, figsize=(7,7))

# 1. sct
sct = sns.scatterplot(x="Trials", y="Pi", s=30, marker="o",
                       data=df,
                      ax=axs[0])
sct.set(title='Monte Carlo Simulation to Estimate Value of Pi',
         xlabel="Number of Trials", ylabel="Value of Pi")
axs[0].axhline(y=3.14, color='r', linestyle='-')


# 2. hst
hst = sns.histplot(df, x="Pi",color='orange', ax=axs[1]);
# hst.set_xlim([df.Pi.min(), df.Pi.max()])
os = .3
hst.set_xlim([2.9 - os, 3.3 + os])
hst.set_title("Histogram of each simulated pi's occurence")
hst.set_xlabel("PI value")
hst.set_ylabel("Count occurence")


fig.tight_layout()
plt.savefig("65050988.pdf")
# plt.show()
print(f'Mean of pi from monte carlo simulation is {df["Pi"].mean()}')