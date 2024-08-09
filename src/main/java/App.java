import org.jpos.iso.ISOException;
import org.jpos.iso.ISOHeader;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;

import java.io.InputStream;

public class App {

    private static final String HEADER = "ISO1987";
    private static final String MTI = "0200"; //financial messages
    public static void main(String[] args) throws ISOException {
        createIsoMessage();
    }

    public static void createIsoMessage() throws ISOException {
        InputStream inputStream = App.class.getResourceAsStream("fields.xml");
        GenericPackager genericPackager = new GenericPackager(inputStream);

        ISOMsg isoMsg = new ISOMsg();
        isoMsg.setPackager(genericPackager);

        isoMsg.setHeader(HEADER.getBytes());
        isoMsg.setMTI(MTI);

        isoMsg.set(2, "5642570404782927");
        isoMsg.set(3, "011000");
        isoMsg.set(4, "78000");
        isoMsg.set(7, "1220145711");
        isoMsg.set(11, "101183");
        isoMsg.set(12, "145711");
        isoMsg.set(13, "1220");
        isoMsg.set(14, "2408");
        isoMsg.set(15, "1220");
        isoMsg.set(18, "6011");
        isoMsg.set(22, "051");
        isoMsg.set(25, "00");
        isoMsg.set(26, "04");
        isoMsg.set(28, "C00000000");
        isoMsg.set(30, "C00000000");
        isoMsg.set(32, "56445700");
        isoMsg.set(37, "567134101183");
        isoMsg.set(41, "N1742");
        isoMsg.set(42, "ATM004");
        isoMsg.set(43, "45 SR LEDERSHIP DUABANAT NUEVA ECIJAQ PH");
        isoMsg.set(49, "608");
        isoMsg.set(102, "970630181070041");
        isoMsg.set(120, "BRN015301213230443463");

        System.out.println("New iso8583 message:\n" + new String(isoMsg.pack()));
        System.out.println("Iso8583 in xml format:");
        isoMsg.dump(System.out, "");
        }
}
