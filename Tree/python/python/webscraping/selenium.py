from selenium import webdriver 

from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By

s = Service("path/chrome/driver")

driver = webdriver.Chrome(service = s)
driver.get("https://www.mediamarkt.es/")

footer = driver.find_element(By.TAG_NAME, "footer")

print(footer.text)
                             
