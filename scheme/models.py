from django.db import models

# Create your models here.



class Scheme(models.Model):
    scheme_id = models.AutoField(primary_key=True)
    scheme_name = models.CharField(max_length=50)
    duration = models.CharField(max_length=50)

    class Meta:
        managed = False
        db_table = 'scheme'
