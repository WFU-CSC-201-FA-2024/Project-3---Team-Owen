public class Patient implements Comparable<Patient>{
    private String gender, CAEC, CALC, mTrans, NObeyesdad;
    private double age, FCVC, NCP, CH2O, FAF, TUE;
    private double height, weight;
    private boolean fHistory, FAVC, SMOKE, SCC;
    public static boolean stringToBoolean(String s) {
        if (s.equals("yes")){
            return true;
        } else {
            return false;
        }
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender=gender;
    }
    public double getAge() {
        return age;
    }
    public void setAge(double age) {
        this.age=age;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height=height;
    }
    public String getCAEC() {
        return CAEC;
    }
    public void setCAEC(String CAEC) {
        this.CAEC = CAEC;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public boolean getFHistory() {
        return fHistory;
    }
    public void setFHistory(boolean fHistory) {
        this.fHistory = fHistory;
    }
    public boolean getFAVC() {
        return FAVC;
    }
    public void setFCVC(double FCVC) {
        this.FCVC = FCVC;
    }
    public double getFCVC() {
        return FCVC;
    }
    public void setFAVC(boolean FAVC) {
        this.FAVC = FAVC;
    }
    public boolean getSMOKE() {
        return SMOKE;
    }
    public void setSMOKE(boolean SMOKE) {
        this.SMOKE = SMOKE;
    }
    public boolean getSCC() {
        return SCC;
    }
    public void setSCC(boolean SCC) {
        this.SCC = SCC;
    }
    public void setNCP(double NCP) {
        this.NCP = NCP;
    }

    public void setCH2O(double CH2O) {
        this.CH2O = CH2O;
    }

    public void setFAF(double FAF) {
        this.FAF = FAF;
    }

    public void setTUE(double TUE) {
        this.TUE = TUE;
    }
    public double getNCP() {
        return NCP;
    }

    public double getCH2O() {
        return CH2O;
    }

    public double getFAF() {
        return FAF;
    }

    public double getTUE() {
        return TUE;
    }
    public void setCALC(String CALC) {
        this.CALC = CALC;
    }

    public void setMTrans(String mTrans) {
        this.mTrans = mTrans;
    }

    public void setNObeyesdad(String NObeyesdad) {
        this.NObeyesdad = NObeyesdad;
    }
    public String getCALC() {
        return CALC;
    }

    public String getMTrans() {
        return mTrans;
    }

    public String getNObeyesdad() {
        return NObeyesdad;
    }



    public Patient(String gender, double age, double height, double weight, String fHistory, String FAVC, double FCVC, double NCP, String CAEC, String SMOKE, double CH2O, String SCC, double FAF, double TUE, String CALC, String mTrans, String NObeyesdad) {
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.fHistory = stringToBoolean(fHistory);
        this.FAVC = stringToBoolean(FAVC);
        this.FCVC = FCVC;
        this.NCP = NCP;
        this.CAEC = CAEC;
        this.SMOKE = stringToBoolean(SMOKE);
        this.CH2O = CH2O;
        this.SCC = stringToBoolean(SCC);
        this.FAF = FAF;
        this.TUE = TUE;
        this.CALC = CALC;
        this.mTrans = mTrans;
        this.NObeyesdad = NObeyesdad;
    }

    public Patient() {
        this.gender=null;
        this.age = 0;
        this.height = 0;
        this.weight = 0;
        this.fHistory = false;
        this.FAVC = false;
        this.FCVC = 0;
        this.NCP = 0;
        this.CAEC = null;
        this.SMOKE = false;
        this.CH2O = 0;
        this.SCC = false;
        this.FAF = 0;
        this.TUE = 0;
        this.CALC = null;
        this.mTrans = null;
        this.NObeyesdad = null;
    }
    public Patient(Patient p) {
        this.gender = p.gender;
        this.age = p.age;
        this.height = p.height;
        this.weight = p.weight;
        this.fHistory = p.fHistory;
        this.FAVC = p.FAVC;
        this.FCVC = p.FCVC;
        this.NCP = p.NCP;
        this.CAEC = p.CAEC;
        this.SMOKE = p.SMOKE;
        this.CH2O = p.CH2O;
        this.SCC = p.SCC;
        this.FAF = p.FAF;
        this.TUE = p.TUE;
        this.CALC = p.CALC;
        this.mTrans = p.mTrans;
        this.NObeyesdad = p.NObeyesdad;
    }

    @Override
    public String toString() {
        return "Gender: "+this.getGender()+", Age: "+this.getAge()+", Height: "+this.getHeight()+", Weight: "+this.getWeight()+", Family History: "+this.getFHistory()+", FAVC: "+this.getFAVC()+
                ", FCVC: "+this.getFCVC()+", NCP: "+this.getNCP()+", CAEC: "+this.getCAEC()+", Smoke: "+this.getSMOKE()+", CH2O: "+this.getCH2O()+", SCC: "+this.getSCC()+
                ", FAF: "+this.getFAF()+", TUE: "+this.getTUE()+", CALC: "+this.getCALC()+", Method of transportation: "+this.getMTrans()+", Obesity level: "+this.getNObeyesdad();
    }


    @Override
    public int compareTo(Patient obj) {
        return Double.compare(this.getWeight(), obj.getWeight());
    }



}
