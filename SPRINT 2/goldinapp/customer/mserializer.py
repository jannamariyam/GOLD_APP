from rest_framework import serializers
from .models import Customer
class mserializer(serializers.ModelSerializer):

    class Meta:
        model=Customer
        fields='__all__'
