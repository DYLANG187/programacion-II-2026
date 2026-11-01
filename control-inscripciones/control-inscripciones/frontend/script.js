const API = "http://localhost:8080/api";

// ===============================
// ACTIVIDADES
// ===============================

async function cargarActividades() {
    try {
        const respuesta = await fetch(`${API}/actividades`);
        const actividades = await respuesta.json();

        const lista = document.getElementById("listaActividades");
        const select = document.getElementById("actividadInscripcion");

        lista.innerHTML = "";
        select.innerHTML = '<option value="">Seleccionar actividad</option>';

        actividades.forEach(actividad => {
            const elemento = document.createElement("div");
            elemento.className = "actividad";

            elemento.innerHTML = `
                <h3>${actividad.nombre}</h3>
                <p><strong>ID:</strong> ${actividad.id}</p>
                <p><strong>Descripción:</strong> ${actividad.descripcion || "Sin descripción"}</p>
                <p><strong>Fecha:</strong> ${actividad.fecha}</p>
                <p><strong>Cupo:</strong> ${actividad.cupo}</p>
                <p><strong>Edad mínima:</strong> ${actividad.edadMinima}</p>

                <div class="acciones">
    <button onclick="editarActividad(${actividad.id})">
        Editar
    </button>

    <button onclick="verOcupacion(${actividad.id})">
        Ver ocupación
    </button>

    <button class="btn-eliminar"
            onclick="eliminarActividad(${actividad.id})">
        Eliminar
    </button>
</div>

                <p id="ocupacion-${actividad.id}"></p>
            `;

            lista.appendChild(elemento);

            const opcion = document.createElement("option");
            opcion.value = actividad.id;
            opcion.textContent = `${actividad.nombre} - ${actividad.fecha}`;

            select.appendChild(opcion);
        });

    } catch (error) {
        document.getElementById("listaActividades").innerHTML =
            '<p class="error">No se pudieron cargar las actividades.</p>';
    }
}

async function cargarActividadesDisponibles() {
    try {
        const respuesta = await fetch(`${API}/actividades/disponibles`);
        const actividades = await respuesta.json();

        const lista = document.getElementById("listaActividades");

        lista.innerHTML = "";

        actividades.forEach(actividad => {
            const elemento = document.createElement("div");
            elemento.className = "actividad";

            elemento.innerHTML = `
                <h3>${actividad.nombre}</h3>
                <p><strong>ID:</strong> ${actividad.id}</p>
                <p><strong>Descripción:</strong> ${actividad.descripcion || "Sin descripción"}</p>
                <p><strong>Fecha:</strong> ${actividad.fecha}</p>
                <p><strong>Cupo:</strong> ${actividad.cupo}</p>
                <p><strong>Edad mínima:</strong> ${actividad.edadMinima}</p>
            `;

            lista.appendChild(elemento);
        });

    } catch (error) {
        document.getElementById("listaActividades").innerHTML =
            '<p class="error">No se pudieron cargar las actividades disponibles.</p>';
    }
}

// Registrar actividad
document.getElementById("formActividad").addEventListener("submit", async function(event) {
    event.preventDefault();

    const actividad = {
        nombre: document.getElementById("nombreActividad").value,
        descripcion: document.getElementById("descripcionActividad").value,
        fecha: document.getElementById("fechaActividad").value,
        cupo: Number(document.getElementById("cupoActividad").value),
        edadMinima: Number(document.getElementById("edadMinimaActividad").value)
    };

    try {
        const respuesta = await fetch(`${API}/actividades`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(actividad)
        });

        const datos = await respuesta.json();

        if (!respuesta.ok) {
            mostrarMensaje("mensajeActividad", obtenerError(datos), true);
            return;
        }

        mostrarMensaje(
            "mensajeActividad",
            "Actividad registrada correctamente.",
            false
        );

        document.getElementById("formActividad").reset();

        cargarActividades();

    } catch (error) {
        mostrarMensaje(
            "mensajeActividad",
            "No se pudo conectar con el servidor.",
            true
        );
    }
});


// Ver porcentaje de ocupación
async function verOcupacion(id) {
    try {
        const respuesta = await fetch(`${API}/actividades/${id}/ocupacion`);
        const porcentaje = await respuesta.json();

        const elemento = document.getElementById(`ocupacion-${id}`);

        if (respuesta.ok) {
            elemento.className = "exito";
            elemento.textContent = `Ocupación: ${Number(porcentaje).toFixed(2).replace(/\.00$/, "")}%`;
        } else {
            elemento.className = "error";
            elemento.textContent = obtenerError(porcentaje);
        }

    } catch (error) {
        document.getElementById(`ocupacion-${id}`).textContent =
            "No se pudo consultar la ocupación.";
    }
}


// Eliminar actividad
async function eliminarActividad(id) {
    if (!confirm("¿Deseas eliminar esta actividad?")) {
        return;
    }

    try {
        const respuesta = await fetch(`${API}/actividades/${id}`, {
            method: "DELETE"
        });

        if (!respuesta.ok) {
            const datos = await respuesta.json();
            alert(obtenerError(datos));
            return;
        }

        alert("Actividad eliminada correctamente.");
        cargarActividades();

    } catch (error) {
        alert("No se pudo conectar con el servidor.");
    }
}


// ===============================
// INSCRIPCIONES
// ===============================

async function cargarInscripciones() {
    try {
        const respuesta = await fetch(`${API}/inscripciones`);
        const inscripciones = await respuesta.json();

        const lista = document.getElementById("listaInscripciones");

        lista.innerHTML = "";

        inscripciones.forEach(inscripcion => {
            const elemento = document.createElement("div");
            elemento.className = "inscripcion";

            const actividad = inscripcion.actividad
                ? inscripcion.actividad.nombre
                : `Actividad ${inscripcion.actividadId}`;

            elemento.innerHTML = `
                <p><strong>ID:</strong> ${inscripcion.id}</p>
                <p><strong>Participante:</strong> ${inscripcion.nombreParticipante}</p>
                <p><strong>Edad:</strong> ${inscripcion.edadParticipante}</p>
                <p><strong>Estado:</strong> ${inscripcion.estado}</p>
                <p><strong>Actividad:</strong> ${actividad}</p>

                <div class="acciones">
                    <button class="btn-cancelar"
                            onclick="cambiarEstado(${inscripcion.id}, '${inscripcion.estado}')">
                        Cambiar estado
                    </button>

                    <button class="btn-eliminar"
                            onclick="eliminarInscripcion(${inscripcion.id})">
                        Eliminar
                    </button>
                </div>
            `;

            lista.appendChild(elemento);
        });

    } catch (error) {
        document.getElementById("listaInscripciones").innerHTML =
            '<p class="error">No se pudieron cargar las inscripciones.</p>';
    }
}


// Registrar inscripción
document.getElementById("formInscripcion").addEventListener("submit", async function(event) {
    event.preventDefault();

    const actividadId = document.getElementById("actividadInscripcion").value;

    const inscripcion = {
        nombreParticipante: document.getElementById("nombreParticipante").value,
        edadParticipante: Number(document.getElementById("edadParticipante").value)
    };

    try {
        const respuesta = await fetch(
            `${API}/inscripciones/actividad/${actividadId}`,
            {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(inscripcion)
            }
        );

        const datos = await respuesta.json();

        if (!respuesta.ok) {
            mostrarMensaje(
                "mensajeInscripcion",
                obtenerError(datos),
                true
            );
            return;
        }

        mostrarMensaje(
            "mensajeInscripcion",
            "Inscripción registrada correctamente.",
            false
        );

        document.getElementById("formInscripcion").reset();

        cargarInscripciones();
        cargarActividades();

    } catch (error) {
        mostrarMensaje(
            "mensajeInscripcion",
            "No se pudo conectar con el servidor.",
            true
        );
    }
});


// Cambiar estado
async function cambiarEstado(id, estadoActual) {

    const nuevoEstado =
        estadoActual === "ACTIVA" ? "CANCELADA" : "ACTIVA";

    try {
        const respuesta = await fetch(
            `${API}/inscripciones/${id}/estado?estado=${nuevoEstado}`,
            {
                method: "PATCH"
            }
        );

        const datos = await respuesta.json();

        if (!respuesta.ok) {
            alert(obtenerError(datos));
            return;
        }

        alert(`Inscripción cambiada a ${nuevoEstado}.`);

        cargarInscripciones();
        cargarActividades();

    } catch (error) {
        alert("No se pudo conectar con el servidor.");
    }
}

async function editarActividad(id) {
    try {
        const respuesta = await fetch(`${API}/actividades/${id}`);
        const actividad = await respuesta.json();

        if (!respuesta.ok) {
            alert(obtenerError(actividad));
            return;
        }

        document.getElementById("idEdicion").value = actividad.id;
        document.getElementById("nombreEdicion").value = actividad.nombre;
        document.getElementById("descripcionEdicion").value = actividad.descripcion || "";
        document.getElementById("fechaEdicion").value = actividad.fecha;
        document.getElementById("cupoEdicion").value = actividad.cupo;
        document.getElementById("edadMinimaEdicion").value = actividad.edadMinima;

        document.getElementById("panelEdicion").style.display = "block";

    } catch (error) {
        alert("No se pudo conectar con el servidor.");
    }
}

// Eliminar inscripción
async function eliminarInscripcion(id) {
    if (!confirm("¿Deseas eliminar esta inscripción?")) {
        return;
    }

    try {
        const respuesta = await fetch(`${API}/inscripciones/${id}`, {
            method: "DELETE"
        });

        if (!respuesta.ok) {
            const datos = await respuesta.json();
            alert(obtenerError(datos));
            return;
        }

        alert("Inscripción eliminada correctamente.");

        cargarInscripciones();
        cargarActividades();

    } catch (error) {
        alert("No se pudo conectar con el servidor.");
    }
}


// ===============================
// MANEJO DE MENSAJES
// ===============================

function mostrarMensaje(idElemento, mensaje, esError) {
    const elemento = document.getElementById(idElemento);

    elemento.textContent = mensaje;
    elemento.className = esError ? "error" : "exito";
}


function obtenerError(datos) {
    if (!datos) {
        return "Ocurrió un error.";
    }

    if (datos.error) {
        return datos.error;
    }

    if (typeof datos === "object") {
        const errores = Object.values(datos);

        if (errores.length > 0) {
            return errores.join(", ");
        }
    }

    return "Ocurrió un error al procesar la solicitud.";
}

document.getElementById("formEdicion").addEventListener("submit", async function(event) {
    event.preventDefault();

    const id = document.getElementById("idEdicion").value;

    const actividad = {
        nombre: document.getElementById("nombreEdicion").value,
        descripcion: document.getElementById("descripcionEdicion").value,
        fecha: document.getElementById("fechaEdicion").value,
        cupo: Number(document.getElementById("cupoEdicion").value),
        edadMinima: Number(document.getElementById("edadMinimaEdicion").value)
    };

    try {
        const respuesta = await fetch(`${API}/actividades/${id}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(actividad)
        });

        const datos = await respuesta.json();

        if (!respuesta.ok) {
            mostrarMensaje("mensajeEdicion", obtenerError(datos), true);
            return;
        }

        mostrarMensaje(
            "mensajeEdicion",
            "Actividad actualizada correctamente.",
            false
        );

        cargarActividades();

    } catch (error) {
        mostrarMensaje(
            "mensajeEdicion",
            "No se pudo conectar con el servidor.",
            true
        );
    }
});

// ===============================
// CARGA INICIAL
// ===============================

cargarActividades();
cargarInscripciones();