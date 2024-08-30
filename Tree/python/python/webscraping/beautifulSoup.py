#!/bin/python3

from bs4 import BeautifulSoup
with open ( '25.Tunisia+Sightseeing.html', 'r') as file:
    html_content = file.read()

soup = BeautifulSoup(html_content, 'html.parser')

print(soup.h2.string)
print(soup.title)
print(soup.p.name)

print("---")
# Extract data from the HTML file by tag name
paragraphs = soup.find_all('p')
for p in paragraphs:
    print(p.getText())

links = soup.find_all('a')
for a in links:
    print(a)
    print(a.getText())

# Extract data from the HTML file by attribute
links = soup.find_all('a')
for link in links:
    print(link.get('href'))

# Extract data from the HTML file by 
elements = soup.find_all(id = 'bardo-museum')
for element in elements:
    print(element.getText())

# Extract data from the HTML file by CSS class
elements = soup.find(class_ = 'museum-list')
for elementcss in elements:
    print(elementcss)


# Extract data from the HTML file by navigating HTML Tree
# parent_element = soup.find('parent_tag')
# child_element = 
# parent_element.find_all('child_tag') 
# for element in child_elements: 
    # print(element)

# Extracting siblings    
item = soup.find('li')
next_sibling = item.find_next_sibling('li')
print(next_sibling.text)

# Extract parent
it1 = soup.find('li')
print(it1)
print(it1.parent.text)
print(it1.parent)

element = soup.select_one("ul li p")
print(element.text)

# Class selector
elements = soup.select_one('.museum-list')
print(elements)

# ID selector
elementid = soup.select_one('#national-museum-of-carthage')
print(elementid.text)

# selector
element = soup.select('[href]')
print(element)