from django.db import models
from scheme.models import  Scheme
# Create your models here.



class Package(models.Model):
    p_id = models.AutoField(primary_key=True)
    # scheme_id = models.IntegerField()
    scheme=models.ForeignKey(Scheme,to_field='scheme_id',on_delete=models.CASCADE)
    type = models.CharField(max_length=30)

    class Meta:
        managed = False
        db_table = 'package'
class Fixed(models.Model):
    slno = models.AutoField(primary_key=True)
    price1 = models.IntegerField()
    price2 = models.IntegerField()
    price3 = models.IntegerField()
    price4 = models.IntegerField()
    price5 = models.IntegerField()
    price6 = models.IntegerField()

    class Meta:
        managed = False
        db_table = 'fixed'
class Variable(models.Model):
    slno = models.AutoField(primary_key=True)
    price1 = models.CharField(max_length=25)
    price2 = models.CharField(max_length=25)
    price3 = models.CharField(max_length=25)
    price4 = models.CharField(max_length=25)
    price5 = models.CharField(max_length=25)
    price6 = models.CharField(max_length=25)

    class Meta:
        managed = False
        db_table = 'variable'
