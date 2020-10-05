package com.app.MedicalHistory;

public class Doctor {
    static class DoctorInformation{
        public int age;
        public int experience;
        public String gender;
        public String specialization;
        public String clinicAddress;
        public int timeWPatient;
        public int points;

//        Const
        DoctorInformation(String gender, String specialization, String clinicAddress, int age, int timeWPatient, int experience, int points){
            this.age = age;
            this.clinicAddress = clinicAddress;
            this.experience = experience;
            this.gender = gender;
            this.points = points;
            this.specialization = specialization;
            this.timeWPatient = timeWPatient;
        }

        public int getDocAge(){return age;}
        public String getDocAddress(){return clinicAddress;}
        public int getDocExperience(){return experience;}
        public String getDocGender(){return gender;}
        public int getDocPoints(){return points;}
        public String getDocSpecial(){return specialization;}
        public int getDocTime(){return timeWPatient;}

        public int addDocPoints(int newPoints){
            return points += newPoints;
        }

        public int addTimeWPatient(){
            return timeWPatient += 1;
        }


    }
}
