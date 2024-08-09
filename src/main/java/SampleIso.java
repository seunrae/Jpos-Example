import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;

import java.io.InputStream;

public class SampleIso {
    private static String HEADER = "ISO1987";
    private static String MTI = "0400";

    public static void main(String[] args) throws ISOException {
        createIsoMessage();
    }

    public static void createIsoMessage() throws ISOException {
        InputStream inputStream = SampleIso.class.getResourceAsStream("myFields.xml");
        GenericPackager packager = new GenericPackager(inputStream);

        ISOMsg isoMsg =new ISOMsg();
        isoMsg.setPackager(packager);
        isoMsg.setHeader(HEADER.getBytes());
        isoMsg.setMTI(MTI);

        isoMsg.set(2, "4111111111111111");
        isoMsg.set(3, "000000");
        isoMsg.set(4, "000000001000");
        isoMsg.set(7, "0707102025");
        isoMsg.set(8, "00001000");
        isoMsg.set(11, "123456");
        isoMsg.set(12, "102025");
        isoMsg.set(13, "0707");
        isoMsg.set(14, "2305");
        isoMsg.set(19, "840");
        isoMsg.set(21, "840");

        System.out.println("Iso message:" + new String(isoMsg.pack()));
    }
}
