// Protege rota: garante sessão
async function checkAuth() {
  const res = await fetch('/api/auth/me');
  if (!res.ok) {
    location.href = '/login.html';
    return null;
  }
  return await res.json();
}

// Logout
document.addEventListener('click', async (e) => {
  if (e.target && e.target.id === 'logoutBtn') {
    await fetch('/api/auth/logout', {method: 'POST'});
    location.href = '/login.html';
  }
});

const app = document.getElementById('app');

function h(title, body='') {
  return `<div class="container"><h2>${title}</h2>${body}</div>`;
}

function input(name, label, type='text', attrs='') {
  return `<label for="${name}">${label}</label><input id="${name}" name="${name}" type="${type}" ${attrs}>`;
}

// ========== Views ==========
const views = {
  home: async () => {
    return h('Bem-vindo(a) ao Sistema Rocha', `<p>Use o menu acima para navegar.</p>`);
  },
  // Motorista
  'cad-contato': async () => {
    return h('Cadastro de Motorista', `
      <form id="formMotorista">
        ${input('nomeMoto', 'Nome', 'text', 'maxlength="200" required')}
        ${input('telefoneMoto', 'Telefone')}
        ${input('datanascMoto', 'Data de Nasc.', 'date')}
        ${input('cpfMoto', 'CPF', 'text', 'maxlength="14"')}
        ${input('enderecoMoto', 'CEP', 'text', 'maxlength="9"')}
        ${input('buonnyMoto', 'Buonny', 'date')}
        ${input('cnhMoto', 'CNH', 'text', 'maxlength="11"')}
        <button type="submit">Salvar</button>
      </form>
      <div id="msg"></div>
    `);
  },
  motorista: async () => {
    const res = await fetch('/api/motoristas');
    const data = await res.json();
    const rows = data.map(m => `
      <tr>
        <td>${m.id}</td><td>${m.nomeMoto||''}</td><td>${m.telefoneMoto||''}</td>
        <td>${m.cpfMoto||''}</td><td>${m.cnhMoto||''}</td>
        <td class="actions">
          <button data-editar="${m.id}">Editar</button>
          <button data-excluir="${m.id}">Excluir</button>
        </td>
      </tr>`).join('');
    return h('Motoristas', `
      <div><a href="#cad-contato">+ Novo</a></div>
      <table><thead><tr><th>ID</th><th>Nome</th><th>Telefone</th><th>CPF</th><th>CNH</th><th>Ações</th></tr></thead>
      <tbody>${rows}</tbody></table>`);
  },

  // Agregado
  'cad-agregado': async () => h('Cadastro de Agregado', `
    <form id="formAgregado">
      ${input('nomeAgregado','Nome','text','required')}
      ${input('telefoneAgregado','Telefone')}
      ${input('cpfAgregado','CPF')}
      <button type="submit">Salvar</button>
    </form>
    <div id="msg"></div>
  `),
  agregado: async () => {
    const res = await fetch('/api/agregados'); const data = await res.json();
    const rows = data.map(x => `<tr><td>${x.id}</td><td>${x.nomeAgregado||''}</td><td>${x.telefoneAgregado||''}</td><td>${x.cpfAgregado||''}</td>
    <td class="actions"><button data-editar-agregado="${x.id}">Editar</button><button data-excluir-agregado="${x.id}">Excluir</button></td></tr>`).join('');
    return h('Agregados', `<div><a href="#cad-agregado">+ Novo</a></div>
    <table><thead><tr><th>ID</th><th>Nome</th><th>Telefone</th><th>CPF</th><th>Ações</th></tr></thead><tbody>${rows}</tbody></table>`);
  },

  // Ajudante
  'cad-ajudante': async () => h('Cadastro de Ajudante', `
    <form id="formAjudante">
      ${input('nomeAjudante','Nome','text','required')}
      ${input('telefoneAjudante','Telefone')}
      ${input('cpfAjudante','CPF')}
      <button type="submit">Salvar</button>
    </form><div id="msg"></div>
  `),
  ajudante: async () => {
    const res = await fetch('/api/ajudantes'); const data = await res.json();
    const rows = data.map(x => `<tr><td>${x.id}</td><td>${x.nomeAjudante||''}</td><td>${x.telefoneAjudante||''}</td><td>${x.cpfAjudante||''}</td>
    <td class="actions"><button data-editar-ajudante="${x.id}">Editar</button><button data-excluir-ajudante="${x.id}">Excluir</button></td></tr>`).join('');
    return h('Ajudantes', `<div><a href="#cad-ajudante">+ Novo</a></div>
    <table><thead><tr><th>ID</th><th>Nome</th><th>Telefone</th><th>CPF</th><th>Ações</th></tr></thead><tbody>${rows}</tbody></table>`);
  },

  // Transporte
  'cad-transporte': async () => {
    const mot = await (await fetch('/api/motoristas')).json();
    const opts = mot.map(m => `<option value="${m.id}">${m.nomeMoto}</option>`).join('');
    return h('Cadastro de Transporte', `
      <form id="formTransporte">
        ${input('descricao','Descrição')}
        ${input('origem','Origem')}
        ${input('destino','Destino')}
        ${input('dataTransporte','Data','date')}
        ${input('valor','Valor','number','step="0.01"')}
        <label for="motoristaId">Motorista</label>
        <select id="motoristaId"><option value="">-- selecione --</option>${opts}</select>
        <button type="submit">Salvar</button>
      </form><div id="msg"></div>
    `);
  },
  transporte: async () => {
    const res = await fetch('/api/transportes'); const data = await res.json();
    const rows = data.map(x => `<tr><td>${x.id}</td><td>${x.descricao||''}</td><td>${x.origem||''}</td><td>${x.destino||''}</td><td>${x.dataTransporte||''}</td><td>${x.valor||''}</td>
    <td>${x.motorista? (x.motorista.nomeMoto||'') : ''}</td>
    <td class="actions"><button data-editar-transporte="${x.id}">Editar</button><button data-excluir-transporte="${x.id}">Excluir</button></td></tr>`).join('');
    return h('Transportes', `<div><a href="#cad-transporte">+ Novo</a></div>
    <table><thead><tr><th>ID</th><th>Descrição</th><th>Origem</th><th>Destino</th><th>Data</th><th>Valor</th><th>Motorista</th><th>Ações</th></tr></thead><tbody>${rows}</tbody></table>`);
  },

  // Cliente
  'cad-cliente': async () => h('Cadastro de Cliente', `
    <form id="formCliente">
      ${input('nomeCliente','Nome','text','required')}
      ${input('telefoneCliente','Telefone')}
      ${input('cnpjCliente','CNPJ')}
      ${input('enderecoCliente','Endereço')}
      <button type="submit">Salvar</button>
    </form><div id="msg"></div>
  `),
  cliente: async () => {
    const res = await fetch('/api/clientes'); const data = await res.json();
    const rows = data.map(x => `<tr><td>${x.id}</td><td>${x.nomeCliente||''}</td><td>${x.telefoneCliente||''}</td><td>${x.cnpjCliente||''}</td><td>${x.enderecoCliente||''}</td>
    <td class="actions"><button data-editar-cliente="${x.id}">Editar</button><button data-excluir-cliente="${x.id}">Excluir</button></td></tr>`).join('');
    return h('Clientes', `<div><a href="#cad-cliente">+ Novo</a></div>
    <table><thead><tr><th>ID</th><th>Nome</th><th>Telefone</th><th>CNPJ</th><th>Endereço</th><th>Ações</th></tr></thead><tbody>${rows}</tbody></table>`);
  },

  // Notas
  'cad-notas': async () => {
    const clientes = await (await fetch('/api/clientes')).json();
    const opts = clientes.map(c => `<option value="${c.id}">${c.nomeCliente}</option>`).join('');
    return h('Cadastro de Nota', `
      <form id="formNota">
        ${input('numeroNota','Número')}
        ${input('dataNota','Data','date')}
        ${input('valor','Valor','number','step="0.01"')}
        <label for="clienteId">Cliente</label>
        <select id="clienteId"><option value="">-- selecione --</option>${opts}</select>
        <button type="submit">Salvar</button>
      </form><div id="msg"></div>
    `);
  },
  notas: async () => {
    const res = await fetch('/api/notas'); const data = await res.json();
    const rows = data.map(x => `<tr><td>${x.id}</td><td>${x.numeroNota||''}</td><td>${x.dataNota||''}</td><td>${x.valor||''}</td>
    <td>${x.cliente? (x.cliente.nomeCliente||'') : ''}</td>
    <td class="actions"><button data-editar-nota="${x.id}">Editar</button><button data-excluir-nota="${x.id}">Excluir</button></td></tr>`).join('');
    return h('Notas', `<div><a href="#cad-notas">+ Nova</a></div>
    <table><thead><tr><th>ID</th><th>Número</th><th>Data</th><th>Valor</th><th>Cliente</th><th>Ações</th></tr></thead><tbody>${rows}</tbody></table>`);
  },
};

// ========== Router ==========
async function render() {
  const auth = await checkAuth();
  if (!auth) return;
  const hash = (location.hash || '#home').substring(1);
  const view = views[hash] || views['home'];
  app.innerHTML = await view();
  bindForms();
}
window.addEventListener('hashchange', render);
window.addEventListener('load', render);

// ========== Bind forms and actions ==========
function bindForms() {
  // Motorista create
  const fm = document.getElementById('formMotorista');
  if (fm) {
    fm.addEventListener('submit', async (e) => {
      e.preventDefault();
      const body = Object.fromEntries(new FormData(fm).entries());
      const res = await fetch('/api/motoristas', {method:'POST', headers:{'Content-Type':'application/json'}, body: JSON.stringify(body)});
      document.getElementById('msg').innerText = res.ok ? 'Salvo!' : 'Erro ao salvar';
      if (res.ok) location.hash = 'motorista';
    });
  }

  // Agregado create
  const fa = document.getElementById('formAgregado');
  if (fa) {
    fa.addEventListener('submit', async (e) => {
      e.preventDefault();
      const body = Object.fromEntries(new FormData(fa).entries());
      const res = await fetch('/api/agregados', {method:'POST', headers:{'Content-Type':'application/json'}, body: JSON.stringify(body)});
      document.getElementById('msg').innerText = res.ok ? 'Salvo!' : 'Erro ao salvar';
      if (res.ok) location.hash = 'agregado';
    });
  }

  // Ajudante create
  const fj = document.getElementById('formAjudante');
  if (fj) {
    fj.addEventListener('submit', async (e) => {
      e.preventDefault();
      const body = Object.fromEntries(new FormData(fj).entries());
      const res = await fetch('/api/ajudantes', {method:'POST', headers:{'Content-Type':'application/json'}, body: JSON.stringify(body)});
      document.getElementById('msg').innerText = res.ok ? 'Salvo!' : 'Erro ao salvar';
      if (res.ok) location.hash = 'ajudante';
    });
  }

  // Transporte create
  const ft = document.getElementById('formTransporte');
  if (ft) {
    ft.addEventListener('submit', async (e) => {
      e.preventDefault();
      const body = Object.fromEntries(new FormData(ft).entries());
      const motoristaId = document.getElementById('motoristaId').value;
      if (motoristaId) body.motorista = { id: Number(motoristaId) };
      const res = await fetch('/api/transportes', {method:'POST', headers:{'Content-Type':'application/json'}, body: JSON.stringify(body)});
      document.getElementById('msg').innerText = res.ok ? 'Salvo!' : 'Erro ao salvar';
      if (res.ok) location.hash = 'transporte';
    });
  }

  // Cliente create
  const fc = document.getElementById('formCliente');
  if (fc) {
    fc.addEventListener('submit', async (e) => {
      e.preventDefault();
      const body = Object.fromEntries(new FormData(fc).entries());
      const res = await fetch('/api/clientes', {method:'POST', headers:{'Content-Type':'application/json'}, body: JSON.stringify(body)});
      document.getElementById('msg').innerText = res.ok ? 'Salvo!' : 'Erro ao salvar';
      if (res.ok) location.hash = 'cliente';
    });
  }

  // Nota create
  const fn = document.getElementById('formNota');
  if (fn) {
    fn.addEventListener('submit', async (e) => {
      e.preventDefault();
      const body = Object.fromEntries(new FormData(fn).entries());
      const clienteId = document.getElementById('clienteId').value;
      if (clienteId) body.cliente = { id: Number(clienteId) };
      const res = await fetch('/api/notas', {method:'POST', headers:{'Content-Type':'application/json'}, body: JSON.stringify(body)});
      document.getElementById('msg').innerText = res.ok ? 'Salvo!' : 'Erro ao salvar';
      if (res.ok) location.hash = 'notas';
    });
  }

  // Delete handlers
  const map = [
    ['button[data-excluir]', '/api/motoristas/', 'motorista'],
    ['button[data-excluir-agregado]', '/api/agregados/', 'agregado'],
    ['button[data-excluir-ajudante]', '/api/ajudantes/', 'ajudante'],
    ['button[data-excluir-transporte]', '/api/transportes/', 'transporte'],
    ['button[data-excluir-cliente]', '/api/clientes/', 'cliente'],
    ['button[data-excluir-nota]', '/api/notas/', 'notas'],
  ];
  map.forEach(([sel, base, hash]) => {
    document.querySelectorAll(sel).forEach(btn => {
      btn.addEventListener('click', async () => {
        const id = btn.getAttribute(Object.keys(btn.dataset)[0].replace(/.*/, Object.keys(btn.dataset)[0]));
        const raw = Object.values(btn.dataset)[0];
        const _id = raw;
        if (confirm('Excluir #' + _id + '?')) {
          await fetch(base + _id, {method:'DELETE'});
          location.hash = hash;
        }
      });
    });
  });
}
