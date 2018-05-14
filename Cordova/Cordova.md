http://ngcordova.com/docs/plugins/


### How to avoid cors issue on browser for ionic app.
Add a proxy parameter to ionic.config.json file. This is when you are able to access the endpoint from POSTMAN but not from browser.

"proxies": [
  {
    "path": "/api",
    "proxyUrl": "https://third-party-or-otherURL.com/api/"
  }
],
