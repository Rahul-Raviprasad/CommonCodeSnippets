# Basic Auth

In pure JS

```js
var requestBody = "";

var client=new XMLHttpRequest();
client.open("get","https://rahulraviprasad.com/api/getSomething");

client.setRequestHeader('Accept','application/json');
client.setRequestHeader('Content-Type','application/json');

//Eg. UserName="admin", Password="admin" for this code sample.
client.setRequestHeader('Authorization', 'Basic '+btoa('admin'+':'+'admin'));

client.onreadystatechange = function() {
  if(this.readyState == this.DONE) {
    document.getElementById("response").innerHTML=this.status + this.response;
  }
};

client.send(requestBody);
```
