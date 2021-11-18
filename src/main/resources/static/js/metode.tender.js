/*!
 * Digunakan untuk filter pilihan metode tender
 */

'use strict';

$(document).ready(function(){
    filterMetodeEvaluasi();

    var idJenisPengadaan = $("#jenis-pengadaan").val();
    var idMetodeKualifikasi;
    var idMetodeDokumen;
    $("#metodeKualifikasi").change(function() {
        $("#metodeEvaluasi option").attr('disabled', true);
        idMetodeKualifikasi = $(this).val();
        filterMetodeDokumen();
        filterMetodeEvaluasi();
    });
    $("#metodeDokumen").change(function() {
        idMetodeDokumen = $(this).val();
        filterMetodeEvaluasi();
    });

    function filterMetodeDokumen() {
        $('#metodeDokumen option[selected="selected"]').attr('selected', false);
        $('#metodeDokumen').prop('selectedIndex',0);
        $("#metodeDokumen option:disabled").removeAttr('disabled');
        if(idMetodeKualifikasi==1){ //prakualifikasi
            $('#metodeDokumen option[value="1"]').attr("disabled", true);//disable satu file
        }else if(idMetodeKualifikasi==2){//pascakualifikasi
            $('#metodeDokumen option[value="3"]').attr("disabled", true);//disable dua tahap
        }
    }

    function filterMetodeEvaluasi() {
        $('#metodeEvaluasi option[selected="selected"]').attr('selected', false);
        $('#metodeEvaluasi').prop('selectedIndex',0);
        $("#metodeEvaluasi option").attr('disabled', true);
        if(idJenisPengadaan==5){ //konsultansi perorangan -> kualitas
            $('#metodeEvaluasi option[value="2"]').attr('disabled', false);
        }else if(idJenisPengadaan==3){//konsultansi badan usaha -> kualitas, kualitas dan biaya, pagu anggaran, biaya terendah
            $('#metodeEvaluasi option[value="2"]').attr('disabled', false);
            $('#metodeEvaluasi option[value="3"]').attr('disabled', false);
            $('#metodeEvaluasi option[value="4"]').attr('disabled', false);
            $('#metodeEvaluasi option[value="5"]').attr('disabled', false);
        }else if(idMetodeKualifikasi==2 && idMetodeDokumen==1){ // pascakualifikasi dan satu file - > Harga Terendah Sistem Gugur
            $('#metodeEvaluasi option[value="1"]').attr('disabled', false);
        }else if(idMetodeKualifikasi==2 && idMetodeDokumen==2){//pascakualifikasi dan dua file -> Sistem nilai, Sistem umur ekonomis, Harga terendah ambang batas
            $('#metodeEvaluasi option[value="6"]').attr('disabled', false);
            $('#metodeEvaluasi option[value="7"]').attr('disabled', false);
            $('#metodeEvaluasi option[value="8"]').attr('disabled', false);
        }else{
            $('#metodeEvaluasi option[value="6"]').attr('disabled', false);
            $('#metodeEvaluasi option[value="7"]').attr('disabled', false);
        }
    }
})