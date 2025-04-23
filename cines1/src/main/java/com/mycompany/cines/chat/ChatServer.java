/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.cines.chat;

import javax.websocket.OnOpen;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.EncodeException;
import java.io.IOException;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;


/**
 *
 * @author 2004p
 */
@ServerEndpoint("/websocket")
public class ChatServer {
private static final Set<Session> peers = Collections.synchronizedSet(new
HashSet<Session>());
@OnOpen
public void onOpen(Session peer) {
peers.add(peer);
}
@OnClose
public void onClose(Session peer) {
peers.remove(peer);
}
@OnMessage
public void message(String message, Session client) throws IOException, EncodeException
{
for (Session peer : peers) {
peer.getBasicRemote().sendText(message);
}
}
}
