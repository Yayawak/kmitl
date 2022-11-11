import json
from urllib.request import Request, urlopen

token = "QSnyKZoHrMzlXHtbo5xd3BtBuM6l9Y04"
resource_id = "1c2f6045-c600-410a-995c-a37a88594ab4"
url = "https://opend.data.go.th/get-ckan/datastore_search?resource_id={}&limit=5".format(resource_id)


req = Request(url)
req.add_header('api-key', token)


content = urlopen(req).read()

encoding = urlopen(req).info().get_content_charset('utf-8')

JSON_object = json.loads(content.decode(encoding))

print(json.dumps(JSON_object, indent=3))
