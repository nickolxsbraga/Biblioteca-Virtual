const formLeitor = document.getElementById("formLeitor");

if (formLeitor) {
    formLeitor.addEventListener("submit", e => {
        e.preventDefault();

        const leitor = {
            nome: document.getElementById("nome").value,
            email: document.getElementById("email").value,
            status: document.getElementById("status").value
        };

        fetch("/api/leitores", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(leitor)
        }).then(() => {
            alert("Leitor cadastrado com sucesso");
            formLeitor.reset();
        });
    });
}