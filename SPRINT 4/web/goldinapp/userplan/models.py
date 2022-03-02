# This is an auto-generated Django model module.
# You'll have to do the following manually to clean this up:
#   * Rearrange models' order
#   * Make sure each model has one field with primary_key=True
#   * Make sure each ForeignKey and OneToOneField has `on_delete` set to the desired behavior
#   * Remove `managed = False` lines if you wish to allow Django to create, modify, and delete the table
# Feel free to rename the models, but don't rename db_table values or field names.
from django.db import models


class Userplan(models.Model):
    plid = models.AutoField(primary_key=True)
    uid = models.IntegerField()
    plan = models.CharField(max_length=10)
    payment = models.CharField(max_length=10)
    jdate = models.DateField()
    nddate = models.DateField()
    pcnt = models.IntegerField()
    amt = models.CharField(max_length=20)
    status = models.CharField(max_length=15)
    class Meta:
        managed = False
        db_table = 'userplan'
