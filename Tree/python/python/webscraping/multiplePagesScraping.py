from bs4 import BeautifulSoup
import requests

url = 'https://www.mediamarkt.es/es/category/televisores-399.html'

headers =  {'User-Agent' : 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/128.0.0.0 Safari/537.36'}

response = requests.get(url, headers= headers)

soup = BeautifulSoup(response.content, 'html.parser')
#print(soup)

tv = soup.find_all('div' , class_ = 'sc-d3a4c5e1-0 iNMUUS')

for tvname in tv: 
    name = tvname.find('a', class_='sc-2fa46f1d-1 gXFxam sc-3edc7bb3-0 ejgCbV')
    print(name.text if name else '' )