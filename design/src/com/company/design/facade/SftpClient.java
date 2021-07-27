package com.company.design.facade;

// Facade Pattern
// 여러개의 객체와 실제 사용하는 서브객체 사이에 복잡한 의존관계가 있을 때 사용
// 각각에 객체에 의존하는게 아닌 퍼사드 객체만 바라볼 수 있다.
// 퍼사드 객체로 복잡한 의존성을 가진 객체들을 하나로 새로운 인터페이스 제공
public class SftpClient {
    private FTP ftp;
    private Reader reader;
    private Writer writer;

    public SftpClient(FTP ftp, Reader reader, Writer writer) {
        this.ftp = ftp;
        this.reader = reader;
        this.writer = writer;
    }

    public SftpClient(String host, int port, String path, String fileName) {
        this.ftp = new FTP(host, port, path);
        this.reader = new Reader(fileName);
        this.writer = new Writer(fileName);
    }

    public void connect() {
        ftp.connect();
        ftp.moveDirectory();
        writer.fileConnect();
        reader.fileConnect();
    }

    public void disConnect() {
        writer.fileDisConnect();
        reader.fileDisConnect();
        ftp.disConnect();
    }

    public void read() {
        reader.fileRead();
    }

    public void write() {
        writer.write();
    }
}
