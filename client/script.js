async function fetchHash() {
    try {
        const res = await fetch("http://localhost:8080/hashtime");
        const data = await res.json();

        const serverHash = data.hash;
        const dateInput = getCurrentTimeInput()
        const clientHash = await sha256(dateInput);
        const isValid = serverHash === clientHash;

        updateUI(serverHash, clientHash, dateInput, isValid)
        addLog(dateInput, isValid)

    } catch (err) {
        console.error("Error fetching hash:", err);
    }

    scheduleNext();
}

function getCurrentTimeInput() {
    const now = new Date();
    now.setUTCSeconds(0, 0);

    return now.toISOString().replace(".000Z", "Z");
}

async function sha256(message) {
    const msgBuffer = new TextEncoder().encode(message);
    const hashBuffer = await crypto.subtle.digest("SHA-256", msgBuffer);
    const hashArray = Array.from(new Uint8Array(hashBuffer));

    return hashArray.map(b => b.toString(16).padStart(2, "0")).join("");
}

function updateUI(serverHash, clientHash, dateInput, isValid) {
    document.getElementById("serverHash").innerText = serverHash;
    document.getElementById("clientHash").innerText = clientHash;
    document.getElementById("datetime").innerText = dateInput;

    const statusEl = document.getElementById("status");
    statusEl.innerText = isValid ? "VALID" : "INVALID";
    statusEl.className = isValid ? "valid" : "invalid";
}

function addLog(dateInput, isValid) {
    const log = document.getElementById("log");
    const entry = document.createElement("li");
    entry.innerText = `${new Date().toLocaleTimeString()}: ${isValid ? "VALID" : "INVALID"} Datetime: ${dateInput}`;
    log.prepend(entry);
}

function scheduleNext() {
    const delay = Math.floor(Math.random() * 8000) + 2000;
    setTimeout(fetchHash, delay);
}

// start
fetchHash();