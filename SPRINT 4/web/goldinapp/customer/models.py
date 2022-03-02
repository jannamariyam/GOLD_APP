# This is an auto-generated Django model module.
# You'll have to do the following manually to clean this up:
#   * Rearrange models' order
#   * Make sure each model has one field with primary_key=True
#   * Make sure each ForeignKey and OneToOneField has `on_delete` set to the desired behavior
#   * Remove `managed = False` lines if you wish to allow Django to create, modify, and delete the table
# Feel free to rename the models, but don't rename db_table values or field names.
from django.db import models


class Customer(models.Model):
    cusid = models.AutoField(primary_key=True)
    name = models.CharField(max_length=25)
    phone = models.CharField(max_length=15)
    email = models.CharField(max_length=25)
    dob = models.CharField(max_length=25)
    nominee = models.CharField(max_length=25)
    nph = models.CharField(max_length=15)
    address = models.CharField(max_length=100)
    pin = models.CharField(max_length=8)
    dist = models.CharField(max_length=25)
    acc = models.CharField(max_length=25)
    jdate = models.DateField()
    lid = models.IntegerField()
    aadr = models.CharField(max_length=20)

    class Meta:
        managed = False
        db_table = 'customer'
