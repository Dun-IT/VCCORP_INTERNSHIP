FROM python:3.8-slim

WORKDIR /flaskapp

# Sao chep file
COPY requirements.txt requirements.txt

# Caif flask trong requirements.txt
RUN pip install -r requirements.txt

# copy thu muc nguon` vao thu muc app cua container
COPY . .

# Chạy Flask trên cổng 5000, chap nhan từ bất kỳ địa chỉ IP nào
CMD ["python", "app.py", "--host", "0.0.0.0", "--port", "5000"]
