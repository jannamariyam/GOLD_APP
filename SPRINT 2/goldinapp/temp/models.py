from django.db import models

class Login(models.Model):
    uid = models.AutoField(primary_key=True)
    uname = models.CharField(max_length=50)
    pwd = models.CharField(max_length=50)
    utype = models.CharField(max_length=12)

    class Meta:
        managed = False
        db_table = 'login'
