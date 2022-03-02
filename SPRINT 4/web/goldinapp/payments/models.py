# This is an auto-generated Django model module.
# You'll have to do the following manually to clean this up:
#   * Rearrange models' order
#   * Make sure each model has one field with primary_key=True
#   * Make sure each ForeignKey and OneToOneField has `on_delete` set to the desired behavior
#   * Remove `managed = False` lines if you wish to allow Django to create, modify, and delete the table
# Feel free to rename the models, but don't rename db_table values or field names.
from django.db import models

from customer.models import Customer
from userplan.models import Userplan
class Payments(models.Model):
    payid = models.AutoField(primary_key=True)
    date = models.DateField()
    # plid = models.IntegerField()
    plid=models.ForeignKey(Userplan,on_delete=models.CASCADE)
    # uid = models.IntegerField()
    cusid=models.ForeignKey(Customer,on_delete=models.CASCADE)
    amout = models.IntegerField()
    inst = models.IntegerField()
    image = models.CharField(max_length=100)
    status = models.CharField(max_length=20)

    class Meta:

        db_table = 'payments'
