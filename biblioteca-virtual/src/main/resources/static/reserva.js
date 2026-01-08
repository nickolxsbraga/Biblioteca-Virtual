const formReserva = document.getElementById("formReserva");

if (formReserva) {
    formReserva.addEventListener("submit", e => {
        e.preventDefault();

        const transacao = {
            livro: { id: document.getElementById("livroId").value },
            leitor: { id: document.getElementById("leitorId").value }
        };

        fetch("/api/transacoes", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(transacao)
        })
        .then(res => {
            if (!res.ok) throw new Error();
            alert("Livro reservado com sucesso");
            formReserva.reset();
        })
        .catch(() => alert("Livro já está reservado"));
    });
}