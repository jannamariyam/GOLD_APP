# This is an auto-generated Django model module.
# You'll have to do the following manually to clean this up:
#   * Rearrange models' order
#   * Make sure each model has one field with primary_key=True
#   * Make sure each ForeignKey and OneToOneField has `on_delete` set to the desired behavior
#   * Remove `managed = False` lines if you wish to allow Django to create, modify, and delete the table
# Feel free to rename the models, but don't rename db_table values or field names.
from django.db import models


class Accountdb(models.Model):
    slno = models.AutoField(primary_key=True)
    acc_no = models.CharField(max_length=25)
    bank = models.CharField(max_length=50)
    ifsc = models.CharField(max_length=10)
    accname = models.CharField(max_length=25)

    class Meta:
        managed = False
        db_table = 'accountdb'



class Penalty(models.Model):
    pn_id = models.AutoField(primary_key=True)
    package = models.CharField(max_length=20)
    type = models.CharField(max_length=20)
    penalty = models.IntegerField()

    class Meta:
        managed = False
        db_table = 'penalty'
