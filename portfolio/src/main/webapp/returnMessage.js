async function returnMessage() {
  const responseFromServer = await fetch('/MyServlet');
  const textFromResponse = await responseFromServer.text();
  const messageContainer = document.getElementById('message-container');
  messageContainer.innerText = textFromResponse;
}