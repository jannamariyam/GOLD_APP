from django.db import models

# Create your models here.
class PriceFixed(models.Model):
    fixed_id = models.AutoField(primary_key=True)
    pamount = models.IntegerField()
    gamount = models.IntegerField()

    class Meta:
        managed = False
        db_table = 'price_fixed'

