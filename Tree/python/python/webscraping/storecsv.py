from bs4 import BeautifulSoup
import csv
with open ('29.csv.html', 'r') as file:
    html_content = file.read()

soup = BeautifulSoup(html_content, 'html.parser')
pillars = soup.find_all('li', class_ = 'pillar')
data = []

for pillar in pillars:
    name = pillar.find('h2').text
    description = pillar.find('p').text
    data.append((name, description))

csv_file = 'pillar.csv'

with open (csv_file , 'w' , newline = '' , encoding='utf-8') as new_csv_file:
    csv_writer = csv.writer(new_csv_file)
    csv_writer. writerow(['Pillar Name','Description'])
    csv_writer.writerow(data)

print(f'Data hasn been extracted and saved to {csv_file}')    