async function returnFacts() {
  const responseFromServer = await fetch('/MyServlet');
  const parsedJsonObject = await responseFromServer.json();
  const index = Math.floor(Math.random() * 3) + 1;
  const fact = parsedJsonObject[`Fact ${index}`]; 
  const messageContainer = document.getElementById('message-container');
  messageContainer.innerText = fact;
}