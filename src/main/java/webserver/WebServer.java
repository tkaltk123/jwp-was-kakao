package webserver;

import webserver.handler.Handlers;

import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    private final Handlers handlers;

    public WebServer(Handlers handlers) {this.handlers = handlers;}

    public void listen(int port) {
        // 서버소켓을 생성한다. 웹서버는 기본적으로 8080번 포트를 사용한다.
        try (ServerSocket listenSocket = new ServerSocket(port)) {
            // 클라이언트가 연결될때까지 대기한다.
            Socket connection;
            while ((connection = listenSocket.accept()) != null) {
                RequestHandler requestHandler = new RequestHandler(connection, handlers);
                Thread thread = new Thread(requestHandler);
                thread.start();
            }
        }
        catch (Exception ignore) {
        }
    }
}
