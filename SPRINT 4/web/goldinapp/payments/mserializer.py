from rest_framework import serializers
from .models import Payments
class mserializer(serializers.ModelSerializer):

    class Meta:
        model=Payments
        fields='__all__'