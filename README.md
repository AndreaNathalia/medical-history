# Medical History

**Idea general:** Plataforma donde una persona pueda tener su historial médico.
- El paciente va al doctor.
- El doctor revisa y diagnostica.
- El doctor redacta ese diagnostico, notas, observaciones, receta de medicinas, etc. en la plataforma.
- Tanto el paciente como el médico tienen acceso a ese historial. (solo el médico puede editar)(el paciente puede dar acceso a los doctores que quiere que editen)
Si el paciente desea asistir con un doctor diferente, ya tiene todo su historial que puede compartir con él y así, el nuevo doctor puede conocer qué enfermedades     ha tenido y qué medicinas ha tomado.


## PRD

***Objetivo de plataforma:***
*¿Qué problema resolvemos?*
El objetivo de la plataforma es brindar acceso rápido y fácil a la información médica de las personas. Brindando un canal de comunicación e información entre el             médico y el paciente, en donde ambos tienen acceso al perfil del otro y el propio.

*¿Quién lo usará?*
Diseñada para personas de 18 años en adelante que desean tener acceso a su perfil médico o al de sus hijos, con información completa, confiable y con una actualización constante.

***Features:***
Dos usuarios diferentes dentro de la plataforma:
**a. Pacientes:**
- Información: 
-Información general (nombre, numero, edad, sexo, estado civil, fecha de nacimiento, ocupación)
-Enfermedades y alergias pasadas y actuales
-Operaciones pasadas
-Fracturas 
-Medicinas pasadas y actuales

• Actividades dentro de la plataforma:
- Puntear al doctor 
- Dar acceso a los doctores para editar el historial
- Agendar consultas con doctores

**b. Médicos:**
• Información:
- Información general (nombre, correo, edad, sexo, especialidad, años de experiencia)
- Dirección de clínica 
- Punteo otorgado por los pacientes
- Tiempo atendiendo al paciente

• Actividades dentro de la plataforma:
- Configuración de días de atención
- Dado el acceso, edición del historial de sus pacientes 


***Criterios de aceptación:***
**• Configuración de días de atención:**
*Criterio de aceptación:* Opción disponible para subir a la plataforma los horarios de atención desde el usuario del médico y que los pacientes lo puedan visualizar.

**• Edición del historial de sus pacientes:**
*Criterio de aceptación:* Con una autorización previa, posibilidad de hacer cambios o agregar información al historial médico del paciente desde el usuario del médico.

**• Puntear al doctor:**
*Criterio de aceptación:* opción para dar un rating al médico desde el usuario del paciente y que esa puntuación forme parte del perfil del médico.

**• Dar acceso a los doctores para editar el historial:**
*Criterio de aceptación:* Opción para brindar y remover acceso de edición al doctor desde el usuario del paciente.

**• Agendar consultas con doctores:**
*Criterio de aceptación:* Opción para agendar una cita médica en base a los horarios disponibles desde el perfil del usuario.

***Llamadas API:***

**GET:**
1. Información general del paciente.
2. Información general del médico tratante.
3. Horarios disponibles para pedir cita.
4. Obtener ratings de doctores.
5. Obtener dirección del médico.
6. Obtener resultados de exámenes médicos realizados.

**POST:**
1. Crear nuevo paciente.
2. Crear nuevo médico.
3. Editar información del paciente.
4. Editar información del médico.
5. Puntuar médico tratante.
6. Publicar días de atención en clínica.

**DELETE:**
1. Eliminar paciente del sistema.
2. Eliminar horario de atención del médico.
3. ancelar cita con medico.
4. Eliminar acceso del médico a la información del paciente.
5. Retirar un médico de la rotación de médicos activos.



