from django.db import models

# Create your models here.
class GoldStatus(models.Model):
    g_id = models.AutoField(primary_key=True)
    image = models.CharField(max_length=150)


    class Meta:
        managed = False
        db_table = 'gold_status'

