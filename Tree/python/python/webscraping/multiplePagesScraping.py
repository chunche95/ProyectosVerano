from bs4 import BeautifulSoup
import requests
import csv

scrap = []

for i in range(1,20):

    url = f"https://www.mediamarkt.es/es/category/televisores-399.html?page={i}"

    headers =  {'User-Agent' : 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/128.0.0.0 Safari/537.36'}

    response = requests.get(url, headers= headers)

    soup = BeautifulSoup(response.content, 'html.parser')
    #print(soup)

    tv = soup.find_all('div' , class_ = 'sc-d3a4c5e1-0 iNMUUS')

    for tvname in tv: 
        name = tvname.find('a', class_='sc-2fa46f1d-1 gXFxam sc-3edc7bb3-0 ejgCbV')
        # print(name.text if name else '' )

        price = tvname.find('span', class_ = 'sc-3f2da4f5-0 iOrmAX sc-dd1a61d2-2 efAprc')
        # print(price.text if price else '')

        description = tvname.find('div', class_ = 'sc-ec2e8e14-0 epARLk')
        # print(description.text if description else '')

        rating = tvname.find('div', class_ = 'sc-caf3c2f0-0 ittdzo')
        # print(rating.text if rating else '')

        # print("-----------------")

        scrap.append({'Name':name, 'Precio':price, 'Descripcion':description, 'Opiniones': rating})

final_file = 'scrapTV.csv'
with open(final_file,  mode='w', newline='', encoding='utf-8' ) as file:
    writer = csv.DictWriter(file, fieldnames = [key for key in scrap[0].keys()])
    writer.writeheader()
    writer.writerows(scrap)

print("Data has been save")