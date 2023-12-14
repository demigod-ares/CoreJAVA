class TypeCasting {
    public static void typeCasting(){
        long minLng = Long.MIN_VALUE, maxLng = Long.MAX_VALUE;
        int minInt = Integer.MIN_VALUE, maxInt = Integer.MAX_VALUE;
        short minSrt = Short.MIN_VALUE, maxSrt = Short.MAX_VALUE;
        byte minByte = Byte.MIN_VALUE, maxByte = Byte.MAX_VALUE;
        System.out.println(minLng + ", " + maxLng + " and " + ((Object)(maxLng/2)).getClass().getName());
        System.out.println(minInt + ", " + maxInt + " and " + ((Object)(maxInt/2)).getClass().getName());
        System.out.println(minSrt + ", " + maxSrt + " and " + ((Object)(maxSrt/2)).getClass().getName());
        System.out.println(minByte + ", " + maxByte + " and " + ((Object)(maxByte/2)).getClass().getName());
        long halfInt = (maxInt/2); System.out.println(halfInt); // no loss 1073741823
        int halfSrt = (maxSrt/2); System.out.println(halfSrt); // no loss 16383
        short halfByte = (short)(maxByte/2); // Result is int
        System.out.println(halfByte); // no loss 63
        byte lossHalfSrt = (byte) (maxSrt/2); // Result is int
        System.out.println(lossHalfSrt); // -1 loss
        short lossHalfInt = (short) (maxInt/2); // Result is int
        System.out.println(lossHalfInt); // -1 loss
        int lossHalfLng = (int) (maxLng/2); // Result is long
        System.out.println(lossHalfLng); // -1 loss
        double myDouble = 35/2.0;
        System.out.println(myDouble);
        float myfloat = (float) (35/2.0);
        System.out.println(myfloat);
    }
    public static void main(String[] args) {
        typeCasting();
    }
}