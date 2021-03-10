async function returnFacts() {
  const responseFromServer = await fetch('/MyServlet');
  const textFromResponse = await responseFromServer.json();
  const pickFact = [textFromResponse["Fact 1"], textFromResponse["Fact 2"], textFromResponse["Fact 3"]];
  const chooseFact = pickFact[Math.floor(Math.random() * pickFact.length)];
  const messageContainer = document.getElementById('message-container');
  messageContainer.innerText = JSON.stringify(chooseFact);
}