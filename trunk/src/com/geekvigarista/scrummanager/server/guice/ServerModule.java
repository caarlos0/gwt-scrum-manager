package com.geekvigarista.scrummanager.server.guice;

import com.geekvigarista.scrummanager.server.actionhandlers.cadastros.usuario.SalvarUsuarioActionHandler;
import com.geekvigarista.scrummanager.shared.commands.usuario.salvar.SalvarUsuarioAction;
import com.gwtplatform.dispatch.server.guice.HandlerModule;

public class ServerModule extends HandlerModule
{
	
	@Override
	protected void configureHandlers()
	{
		bindHandler(SalvarUsuarioAction.class, SalvarUsuarioActionHandler.class);
	}
}