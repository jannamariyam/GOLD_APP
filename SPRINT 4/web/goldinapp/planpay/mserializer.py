from rest_framework import serializers
from .models import PlanPay
class mserializer(serializers.ModelSerializer):

    class Meta:
        model=PlanPay
        fields='__all__'