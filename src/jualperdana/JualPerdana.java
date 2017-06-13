/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jualperdana;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class JualPerdana {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        tableperdana entityObjk =new tableperdana();
        QueryOcid tambah = new QueryOcid();
        Scanner input=new Scanner(System.in);
        String nama,alamat,jwb;
        long id;
        
        System.out.println("SELAMAT DATANG DI TOKO PERDANA");
        System.out.println("moggo isi bio data dulu ");
        System.out.print("Nama Lengkap :");nama = input.nextLine();
        System.out.print("Alamat  :");alamat=input.nextLine();
        entityObjk.setNama(nama);
        entityObjk.setAlamat(alamat);
        tambah.Add(entityObjk);
        
        System.out.println("Apakah data anda ingin dilihat kan ? jawab ya/no");jwb=input.nextLine();
        if(jwb.equals("ya")){
        tambah.Show();
        }
        
        System.out.println("Apakah data anda ingin di rubah kan ? jawab lanjut/tidak");jwb=input.nextLine();
        if(jwb.equals("lanjut")){
            System.out.print("Nama :");nama = input.nextLine();
            System.out.print("Alamat :");alamat = input.nextLine();
            System.out.print("ID :");id=input.nextLong();
            tambah.update(id,nama,alamat);
            tambah.Show();
        }
        
        System.out.println("Apakah data anda ingin di hapus kan ? jawab lanjut/tidak");jwb=input.nextLine();
        if(jwb.equals("lanjut")){
            System.out.print("ID :");id=input.nextLong();
            tambah.hapus(id);
            tambah.Show();
        }
        

    }
    
}
