import pandas as pd
import matplotlib.pyplot as plt
pokemon_df = pd.read_csv("Pokemon.csv")
# How many Pokémons are with 'Type 1' == Water as a % of total?
type1_pokemons = pokemon_df['Type 1'].value_counts(normalize=True).reset_index()
print(type1_pokemons)

num_water_type_pokemons = len(pokemon_df[pokemon_df['Type 1'] == 'Water'])
total_pokemons = len(pokemon_df)
percentage_water_type = (num_water_type_pokemons / total_pokemons) * 100
rounded_percentage_water_type = str(round(percentage_water_type))
print(f'{rounded_percentage_water_type} % of all pokemons are Water type')

# What is the maximum 'Speed' value? What is the minimum 'Speed' value?
min_speed=pokemon_df['Speed'].min()
max_speed=pokemon_df['Speed'].max()
print(f'Maximum speed value is {max_speed}, minimum speed value is {min_speed}')

# What is the difference between max and min 'Speed'?
minmax_difference = max_speed - min_speed
print(f'The difference between Maximum and Minimum Speed is {minmax_difference}')

# Filter the DataFrame to include only the Pokémon with 'Speed' >= 80. 
speed_above_80 = pokemon_df[pokemon_df['Speed']>=80]
fast_pokemons = speed_above_80
# How many Pokémon meet this criterion? Display this DataFrame using your preferred visualization method.
count_speed_above_80=len(speed_above_80)
num_pokemons = count_speed_above_80
print(f'{count_speed_above_80} pokemons have speed value equal or above 80')
# Histogram 
plt.hist(fast_pokemons['Speed'], bins = 20, color = 'khaki', edgecolor = 'tan', alpha = 0.7)
plt.xlabel('Speed')
plt.ylabel('Amount of Pokemons')
plt.title('Pokemons distribution with Speed >= 80')
plt.grid(linestyle = '--',  alpha = 0.7)
plt.show()
# Bar chart
plt.figure(figsize=(12, 8))
plt.bar(speed_above_80['Speed'].values, speed_above_80['Speed'], color='skyblue')
plt.title('Pokémon with Speed >= 80')
plt.xlabel('Speed')
plt.ylabel('Count')
plt.show()
# Pie chart
percentage_filtered_pokemons = (num_pokemons / total_pokemons) * 100

sizes = [percentage_filtered_pokemons, 100 - percentage_filtered_pokemons]
labels = ['Speed >= 80', 'Others']
colors = ['pink', 'skyblue']

plt.figure(figsize=(8, 8))
plt.pie(sizes, labels=labels, colors=colors, startangle=140)
plt.title('Percentage of Pokemon with Speed >= 80')
plt.show()
