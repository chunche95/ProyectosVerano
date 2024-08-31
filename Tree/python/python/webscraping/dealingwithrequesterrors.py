from bs4 import BeautifulSoup
import requests
import csv

url = 'https://www.imdb.com/chart/top/'

headers = {'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/128.0.0.0 Safari/537.36'}

response = requests.get(url, headers=headers)

soup = BeautifulSoup(response.content, 'html.parser')

# print(soup)

movies = soup.find_all('li' , class_='ipc-metadata-list-summary-item sc-10233bc-0 TwzGn cli-parent')

print(len(movies))

csv_file = 'moviedata.csv'

with open(csv_file,  mode = 'w', newline='' , encoding='utf-8-sig') as file:
    writer = csv.writer(file)

    header = ['Rank' , ' Name' , 'Year' , 'Rating']
    writer.writerow(header)


    for movie in movies:
        rank = movie.find('div' , class_ = 'ipc-title ipc-title--base ipc-title--title ipc-title-link-no-icon ipc-title--on-textPrimary sc-b189961a-9 bnSrml cli-title').a.text.split('.')[0]
        titles = movie.find('div' , class_ = 'ipc-title ipc-title--base ipc-title--title ipc-title-link-no-icon ipc-title--on-textPrimary sc-b189961a-9 bnSrml cli-title').a.text.split('.')[1]
        year = movie.find('div', class_ = 'sc-b189961a-7 btCcOY cli-title-metadata').span.text
        rating = movie.find('div' , class_ = 'sc-e2dbc1a3-0 jeHPdh sc-b189961a-2 bglYHz cli-ratings-container').span.text

        #print(f'{rank} - {titles} Año: {year} - Calificación: {rating}')
        data = [rank, titles, year, rating]
        writer.writerow(data)
        
print("Data has been written to the CSV file.")        
