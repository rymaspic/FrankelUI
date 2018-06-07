package UI.tools.image;

import UI.tools.encryption.AES_Encryption;
import UI.tools.encryption.RSA_Encryption;

import java.util.Objects;

/**
 * ImageBrick is a constituent part of ImageWall used to chop a picture into 8 * 8 squares.
 * @author Yu.M
 * Created in 20:25 2018/6/7
 * Modified by Frankel.Y
 */
public class ImageBrick {

    public byte[] clay;

    ImageBrick() {
        clay = new byte[8];
    }

    void insertHash(byte[] hashValue) {
        for(int i=0; i < 8; i++) {
            clay[i] = (byte)(clay[i] ^ hashValue[i]);
        }
    }

    void encrypt(String password, int encrypType) {
        byte[] secret = new byte[8];

        if(encrypType == ImageWall.ENCRYP_TYPE_AES) {
            secret = AES_Encryption.encrypt(clay, password);
        }else if(encrypType == ImageWall.ENCRYP_TYPE_RSA) {
            secret = RSA_Encryption.encrypt(clay,password);
        }

        clay = Objects.requireNonNull(secret).clone();
    }
}